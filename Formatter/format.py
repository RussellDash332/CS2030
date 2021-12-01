import sys

lines = ["// START //\n"]

for line in sys.stdin:
    if line[:7] in ["jshell>", "   ...>"]:
        lines.append(line[8:])
    # elif line[:7] == "   ...>":
    #     lines[-1] = lines[-1][:-1] + line[8:]

print(str().join(lines))