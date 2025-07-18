from Utils.menu import menu
from Utils.get_mc_version import get_mc_version
from Utils.get_launcher import get_launcher
import subprocess
import sys
import os
import shutil

def export_modpack():
    folders = get_mc_version()
    minecraft_version = menu(folders, "Select a Minecraft version:")
    if minecraft_version is None:
        return
    launcher = get_launcher()
    if launcher is None:
        return
    # Build the path to the correct directory: ../<minecraft_version>/<launcher>
    modpack_dir = os.path.join("..", minecraft_version, launcher)
    if not os.path.isdir(modpack_dir):
        print(f"Directory {modpack_dir} does not exist.")
        return

    # Simplified copy logic for configureddefaults, .packwizignore, and icon.png

    files_to_copy = [
        {
            "src": os.path.join("..", "Template", "Config"),
            "dst": os.path.join(modpack_dir, "configureddefaults"),
            "is_dir": True,
            "desc": "configureddefaults"
        },
        {
            "src": os.path.join("..", "Template", ".packwizignore"),
            "dst": os.path.join(modpack_dir, ".packwizignore"),
            "is_dir": False,
            "desc": ".packwizignore"
        },
        {
            "src": os.path.join("..", "Template", "icon.png"),
            "dst": os.path.join(modpack_dir, "icon.png"),
            "is_dir": False,
            "desc": "icon.png"
        }
    ]

    for item in files_to_copy:
        src, dst, is_dir, desc = item["src"], item["dst"], item["is_dir"], item["desc"]
        if not os.path.exists(src):
            print(f"Source {desc} {'directory' if is_dir else 'file'} {src} does not exist.")
            return
        try:
            if is_dir:
                if os.path.exists(dst):
                    shutil.rmtree(dst)
                shutil.copytree(src, dst)
            else:
                shutil.copy2(src, dst)
            print(f"Copied {src} to {dst}")
        except Exception as e:
            print(f"Error copying {desc}: {e}")
            sys.exit(1)

    # Fonction utilitaire pour exécuter une commande packwiz et gérer les erreurs
    def run_packwiz_cmd(cmd, cwd):
        try:
            subprocess.run(cmd, check=True, cwd=cwd)
        except subprocess.CalledProcessError as e:
            print(f"Error running {' '.join(cmd)} in {cwd}: {e}")
            sys.exit(1)

    # Exécute les deux commandes nécessaires
    run_packwiz_cmd(['packwiz', 'refresh'], modpack_dir)
    run_packwiz_cmd(['packwiz', launcher.lower(), 'export'], modpack_dir)