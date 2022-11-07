li = [1236,1248,1284,1296,1326,1352,1365,1378,1428,1456,1498,1632,1648,1734,1768,1785,1836,1854,1872,1938,1957,1976,2163,2184,2346,2369,2496,2678,2754,2781,2856,2958,2987,3162,3264,3296,3468,3672,3876,3978,4182,4386,4692,4896]

allI = []

for x in li:
	for y in li:
		combined = str(x) + str(y)
		unique = True
		for item in combined:
			if combined.count(item) > 1:
				unique = False
		if unique:
			so = sorted(combined)
			# print(so)
			missingDigit = ""
			for i in range(1,10):
				missing = True
				for dig in so:
					if str(i) == dig:
						missing = False
						continue
				if missing == True:
					missingDigit = str(i)
			# print(missingDigit)
			print(combined)
			print("".join(so))
			input()

			firstFour = combined[:4]
			lastFour = combined[4:]

			if int(firstFour) % int(missingDigit) == 0 and int(lastFour) % int(missingDigit) == 0:
				print(f"{firstFour} % {missingDigit}   and   {lastFour} % {missingDigit}")
				allI.append(combined)
				# input()
print(allI)
print(f"\n\n\n{len(allI)}")