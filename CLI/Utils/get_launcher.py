from Utils.menu import menu

def get_launcher():
    launcher = menu(["Modrinth", "CurseForge"], "Select a launcher:")
    return launcher
