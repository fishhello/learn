import statistics

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


nums = [1, 5, 33, 21, 55]
statistics.mean(nums)

# 中值
statistics.median(nums)

# 众值
statistics.mode(nums)

class Orange:
    def __init__(self, w, c):
        self.weight = w
        self.color = c
        print("created!")
    

or1 = Orange(10,"yellow")
print(or1.weight)
print(or1.color)
or1.weight = 20
or1.color = "dark"
print(or1.weight)
print(or1.color)

class Orange:
    # 类创建对象实例
    def __init__(self, w, c):
        self.weight = w
        self.color = c
        self.mold = 0
        print("created!")


    # 计算橘子的腐烂公式 
    def rot(self, days, temp):
        self.mold = days * temp
    

orange = Orange(6, "green")
print(orange.mold)
orange.rot(10,34)
print(orange.mold)


class Rectangle():
    def __init__(self, w, l):
        self.width = w
        self.len = l

    def area(self):
        return self.width * self.len

    def change_size(self, w, l):
        self.width = w
        self.len = l


rectangle = Rectangle(30, 40)
print(rectangle.area())
rectangle.change_size(40, 50)
print(rectangle.area())


class Shape():
    def __init__(self, w, l):
        self.width = w
        self.len = l
    
    def print_size(self):
        print(" {} by {}".format(self.width, self.len))


class Square(Shape):
    pass


my_square = Square(20, 25)
my_square.print_size()


class Dog():
    def __init__(self, name, bread, owner):
        self.name = name
        self.bread = bread
        self.owner = owner
    

class Person():
    def __init__(self, name):
        self.name = name


mick = Person("make")
stan = Dog("job", "bulldog", mick)
print(stan.owner.name)
