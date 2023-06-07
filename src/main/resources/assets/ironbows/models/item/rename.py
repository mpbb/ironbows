import os

prefixes = [
    "iron",
    "golden",
    "diamond",
    "emerald",
    "netherite"
]

for f in os.listdir():
    if not f.startswith("prefix"):
        continue
    with open(f, 'r') as template:
        newData = template.read()
        for p in prefixes:
            with open(f.replace("prefix", p), 'w') as newFile:
                newFile.write(newData.replace("prefix", p).replace("item/", "ironbows:item/"))