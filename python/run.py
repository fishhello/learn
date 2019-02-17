print("你好吖!")
print("""This is a
    long line code.""")

x = 10
x += 1
print(x)

lists = []
rap = ["1", "2", "3"]
rock = ["4", "5", "6"]
djs = ["7", "8", "9"]
lists.append(rap)
lists.append(rock)
lists.append(djs)
rap = lists[0]
rap.append("hello")
print(lists)


location = []
la = (12.11, 34.444)
chicago = (223.1, 565.4)
location.append(la)
location.append(chicago)
print(location)


rap = ["1", "2", "3"]
rock = ["4", "5", "6"]
somemusic = (rap, rock)
print(somemusic)

fruits = {"apple": "red", "banana": "yellow"}
my_list = [fruits]
print(my_list)
my_tuple = (fruits,)
print(my_tuple)


mydict = {
    "location": (40.221, 74.222),
    "celebs": ["allen", "jay", "bacon"],
    "facts": {"state": "ny", "country": "usa"}
}
print(mydict)

"hello"*2

"hello ha".capitalize()

"{}fish".format("sha")


value = "once upon a time.I jumped over the puddle".split(".")
print(value)


join_thing = "abc"
result = "+".join(join_thing)
print(result)

test = '  hello  '
print(test.strip())


replace_test = "hello this is a replace test"
print(replace_test.replace("this", "kao"))

print("aninals".index("i"))

print("\nhello\nworld")


fict = ["Toast", "asian", "austin", "orwell"]
print(fict[0:2])
print(fict[:2])
print(fict[2:])

name = "shafish"
for char in name:
    print(char)

tv = ["error", "ok", "false", "true"]
i = 0
for show in tv:
    new = tv[i]
    new = new.upper()
    tv[i] = new
    i += 1


print(tv)

tv = ["error", "ok", "false", "true"]
for i, show in enumerate(tv):
    new = tv[i]
    new = new.upper()
    tv[i] = new


print(tv)

for i in range(1, 9):
    print(i)

x = 10
while x > 0:
    print('{}'.format(x))
    x -= 1
print("新年好！！")

for i in range(1, 6):
    print(i)
    if i == 2:
        break
