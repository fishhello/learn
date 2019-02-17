## 文件操作
> python内置函数：open打开文件，两个参数,一个表示打开文件路径的字符串，一个表示打开文件的模式

> os模块：创建文件的路径

```python
st = open("st.txt","w")
st.write("hi,this is a open test")
st.close()

"r":只读模式打开，“w”:只写模式打开文件，如果文件已存在会覆盖文件，如果文件不存在就会创建一个新的文件，“w+”:可读可写模式，其他与w模式差不多
```

### 推荐写法
```python
with open("st.txt","w") as f:
    f.write("hi this is a open test")

只要在with语句内就可以访问文件对象，运行完毕后会自动关闭文件
```

### 读取文件
```python
my_list = list()
with open("st.txt","r") as f:
    my_list.append(f.read())


print(my_list)

['hi this is hhhhh']
read()方法会返回一个包含文件所有行的可迭代对象
```

### csv文件
> 可以用Excel打开csv文件，可以使用逗号或|分隔数据

```python
import csv


with open("st.csv","w") as f:
    w = csv.write(f,w.writerow(["one", "twe", "three"]) w.riterow(["four", "five", "six"]))

# 会创建一个st.csv的文件，并写入内容
```
```python
import csv


with open("st.txt","r") as f:
    r = csv.reader(f,delimiter=",")
    for row in r:
        print(",".join(row))

one,twe,three
four,five,six
```