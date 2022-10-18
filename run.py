import os
from rich.console import Console

c = Console()

files = os.listdir()

available = {}
i = 1

c.clear()

c.print("[bold][underline]File to run")
c.rule()

for file in files:
	if "app" in file.lower() and ".java" in file.lower():
		c.print(f"{i} . {file}")
		available[i] = file
		i += 1

c.print("\n")

usr = 0

def processInput(usr_input):
	if "x" in str(usr):
		return usr_input[:1]
	elif len(str(usr)) > 1 and not str(usr)[1].isnumeric():
		return 0
	return usr_input



while not int(processInput(usr)) in available.keys():

	usr = input()


def fileRunner(file: str, iteration=""):
	c.rule(f"[green]{file}.java Output{iteration}")
	c.print("\n")

	os.system(f"javac {file}.java")

	os.system(f"java {file}")

	c.print("\n")

	c.rule(f"[red]{file}.java Output{iteration}{' ' if iteration != '' else ''}Finished")




c.clear()

if "x" in usr:
	file = available[int(usr[0])].split(".")[0]

	iterations = int(usr.split("x")[1])

	try:
		for i in range(iterations):
			fileRunner(file, f" #{i + 1}")
	except KeyboardInterrupt:
		c.print("\n\n")
		c.rule("[red]Exiting")


else:
	file = available[int(usr)].split(".")[0]

	fileRunner(file)
