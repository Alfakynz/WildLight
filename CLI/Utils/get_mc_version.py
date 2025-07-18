from pathlib import Path

def get_mc_version():
    # Get all Minecraft version directories (folders with digits in name, not hidden)
    folders = sorted([
        f.name
        for f in Path("../").iterdir()
        if f.is_dir()
        and not f.name.startswith('.')
        and any(c.isdigit() for c in f.name)
    ])

    return folders