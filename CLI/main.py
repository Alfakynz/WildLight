from Utils.menu import menu
from build_pack_content import build_pack_content
from export_modpack import export_modpack
from update_modpack_version import update_modpack_version

def main():
    select = menu(["Export modpack", "Build pack content", "Update modpack version"], "What do you want to do?")
    match select:
        case "Export modpack":
            export_modpack()
            main()
        case "Build pack content":
            build_pack_content()
            main()
        case "Update modpack version":
            update_modpack_version()
            main()
        case None:
            return
        case _:
            print("Invalid selection")

if __name__ == "__main__":
    main()
