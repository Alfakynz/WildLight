from Utils.menu import menu

def get_launcher(all = False):
    if all:
        launcher = menu(["All", "Modrinth", "CurseForge"], "Select a launcher:")
    else:
        launcher = menu(["Modrinth", "CurseForge"], "Select a launcher:")
    return launcher
