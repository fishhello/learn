import csv


with open("st.txt", "w") as f:
    f.write("hi this is hhhhh")

my_list = list()
with open("st.txt", "r") as f:
    my_list.append(f.read())

print(my_list)

with open("st.csv",  "w") as f:
    w = csv.writer(f, delimiter=",")
    w.writerow(["one", "twe", "three"])
    w.writerow(["four", "five", "six"])

with open("st.csv", "r") as f:
    r = csv.reader(f, delimiter=",")
    for row in r:
        print(",".join(row))
