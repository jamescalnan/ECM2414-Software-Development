import os
from rich.console import Console
import subprocess

c = Console()

files = os.listdir()

available = {}
i = 1
for file in files:
	if ".java" in file.lower():
		c.print(f"{i} : {file}")
		available[i] = file
		i += 1

c.print("\n\n")
usr = input()

file = available[int(usr)].split(".")[0]


c.clear()

c.rule(f"[green][bold]{file}.java Output")
c.print("\n")

os.system(f"javac {file}.java")

os.system(f"java {file}")

c.print("\n")

c.rule(f"[red][bold]{file}.java Output Finished")
