import curses
import os
import tomllib
from pathlib import Path

OUTPUT_FILE = "PACK_CONTENT.md"

# Run this script in the CLI directory. 
# Function to select a directory using curses
def select_directory_with_curses():
  def inner(stdscr):
    curses.curs_set(0)
    folders = sorted([
      f.name
      for f in Path("../").iterdir()
      if f.is_dir()
      and not f.name.startswith('.')
      and any(c.isdigit() for c in f.name)
    ])
    folders.append("Quit")
    current_row = 0

    while True:
      stdscr.clear()
      stdscr.addstr(0, 0, "Select a Minecraft version:\n", curses.A_BOLD)
      for i, folder in enumerate(folders):
        if i == current_row:
          stdscr.attron(curses.color_pair(1))
          stdscr.addstr(i + 1, 0, f"> {folder}")
          stdscr.attroff(curses.color_pair(1))
        else:
          stdscr.addstr(i + 1, 0, f"  {folder}")
      key = stdscr.getch()
      if key == curses.KEY_UP and current_row > 0:
        current_row -= 1
      elif key == curses.KEY_DOWN and current_row < len(folders) - 1:
        current_row += 1
      elif key in [10, 13]:  # Enter
        if folders[current_row] == "Quit":
          return None
        return folders[current_row]
      stdscr.refresh()

  curses.wrapper(lambda stdscr: curses.init_pair(1, curses.COLOR_BLACK, curses.COLOR_WHITE))
  return curses.wrapper(inner)

def main():
  # Minecraft version
  minecraft_version = select_directory_with_curses()
  if minecraft_version is None:
      return
  # List all mods in the specified Minecraft version directory.
  mods = list_projects(minecraft_version, "mods")
  resourcepacks = list_projects(minecraft_version, "resourcepacks")
  shaderpacks = list_projects(minecraft_version, "shaderpacks")

  if mods:
    print(f"Found {len(mods)} mods for Minecraft v{minecraft_version}.")
  else:
    print(f"No mods found for Minecraft v{minecraft_version}.")

  if resourcepacks:
    print(f"Found {len(resourcepacks)} resource packs for Minecraft v{minecraft_version}.")
  else:
    print(f"No resource packs found for Minecraft v{minecraft_version}.")

  if shaderpacks:
    print(f"Found {len(shaderpacks)} shader packs for Minecraft v{minecraft_version}.")
  else:
    print(f"No shader packs found for Minecraft v{minecraft_version}.")

  output_file = Path(f"../{minecraft_version}/{OUTPUT_FILE}")

  # Write the projects to a markdown file.
  with open(output_file, "w", encoding="utf-8") as f:
    f.write("# List of projects used\n\n")
    f.write("- [Mods used](#mods-used)\n")
    f.write("- [Resource packs used](#resource-packs-used)\n")
    f.write("- [Shader packs used](#shader-packs-used)\n\n")
    f.write("## Mods used\n\n")
    f.write("\n".join(sorted(mods)))
    f.write("\n\n## Resource packs used\n\n")
    f.write("\n".join(sorted(resourcepacks)))
    f.write("\n\n## Shader packs used\n\n")
    f.write("\n".join(sorted(shaderpacks)))

    print(f"Added {len(mods)} mods in {output_file}")
    print(f"Added {len(resourcepacks)} resource packs in {output_file}")
    print(f"Added {len(shaderpacks)} shader packs in {output_file}")

# List projects in the specified Minecraft version and type (mods, resourcepacks, shaderpacks).
def list_projects(minecraft_version, type):
  projects_folder = Path(f"../{minecraft_version}/Modrinth/{type}")
  if not projects_folder.exists():
    print(f"The {projects_folder} folder doesn't exist.")
    return []

  projects = []
  for file in projects_folder.glob("*.toml"):
    with open(file, "rb") as f:
      data = tomllib.load(f)
      try:
        name = data["name"]
        project_id = data["update"]["modrinth"]["mod-id"]
        url = f"https://modrinth.com/project/{project_id}"
        projects.append(f"- [{name}]({url})")
      except KeyError as e:
        print(f"Missing key in {file.name}: {e}")

  return sorted(projects)

main()