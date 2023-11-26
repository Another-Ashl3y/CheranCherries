out_file = "character_set.blossom"

data = []

characters = list("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ")
data.append(str(characters).replace("[","{").replace("]","}").replace("\'","\""))

for i in characters:
    data.append(f"STO {characters.index(i)+100} {characters.index(i)}     {i}")

out = ""
for i in data:
    out += i + "\n"


with open(out_file, "w") as f:
    f.write(out)