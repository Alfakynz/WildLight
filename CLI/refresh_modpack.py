from Utils.menu import menu
from Utils.get_mc_version import get_mc_version
from Utils.get_launcher import get_launcher
from Utils.run_packwiz_cmd import run_packwiz_cmd
import os

def refresh_modpack():
    folders = get_mc_version()
    minecraft_version = menu(folders, "Select a Minecraft version:")
    if minecraft_version is None:
        return

    launcher = get_launcher(all = True)
    if launcher is None:
        return
    
    if launcher == "All":
        launchers = ["Modrinth", "CurseForge"]
    else:
        launchers = [launcher]

    for current_launcher in launchers:
        modpack_dir = os.path.join("..", minecraft_version, current_launcher)
        if not os.path.isdir(modpack_dir):
            print(f"Directory {modpack_dir} does not exist.")
            continue

        run_packwiz_cmd(['packwiz', 'refresh'], modpack_dir)