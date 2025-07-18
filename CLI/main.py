from Utils.menu import menu
from build_pack_content import build_pack_content
from export_modpack import export_modpack

def main():
    select = menu(["Export modpack", "Build pack content"], "What do you want to do?")
    match select:
        case "Export modpack":
            export_modpack()
        case "Build pack content":
            build_pack_content()
        case _:
            print("Invalid selection")

if __name__ == "__main__":
    main()
