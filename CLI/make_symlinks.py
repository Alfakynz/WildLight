import os

# This script creates symlinks for the specified files in the current directory. Use it on CurseForge or Modrinth directories (python3 ../../CLI/make_symlinks.py). 
# List of (target_path, symlink_path) pairs
symlinks = [
    ("../../Options/options.txt", "options.txt"),
    ("../../Packwiz/icon.png", "icon.png"),
    ("../../Packwiz/.packwizignore", ".packwizignore"),
]

for target_path, symlink_path in symlinks:
    try:
        # Check if the symlink or file already exists
        if os.path.islink(symlink_path) or os.path.exists(symlink_path):
            print(f"The file or symlink '{symlink_path}' already exists.")
        else:
            os.symlink(target_path, symlink_path)
            print(f"Symlink created: {symlink_path} -> {target_path}")
    except OSError as e:
        print(f"Error creating symlink for {symlink_path}: {e}")