## 字符串操作
>字符串是无法修改的，如果需要修改就必须创建一个新的字符串

### 三引号字符串:"""
>如果字符串超过一行，可以使用三引号
```
print("""This is a
    long line code.""")
```

### 索引
>字符串也是可以迭代的

```python
author = "kafka"
author[3] :k
```

### 负索引
>从右往左查找元素的索引

```python
author = "kafka"
author[-1] :a
```

### 字符串拼接：+
```python
#使用加号
“cat”+“in”+“hat”
"catinhat"
```

### 字符串乘法:*
```python
"hello" * 2

'hellohello'
```

### 大小写
```python
"hello".upper()
"HELLO".lower()
#字符串首字母大写
"hello ha".capitalize() :'Hello ha'
```

### 格式化：format
>使用format创建新的字符串，可以将字符串中的{}转换为传入的字符串
```python
"{}fish".format("sha") :'shafish'
```

### 分割：split
```python
value = "once upon a time.I jumped over the puddle".split(".")
print(value)

['once upon a time', 'I jumped over the puddle']
```

### 连接：join
>可以在字符的每个字符间添加新字符
```python
join_thing = "abc"
result = "+".join(join_thing)

a+b+c
```

### 去除空格：strip
>去除字符串开头结尾空白字符
```python
test = '  hello  '
test.strip() :hello
```

### 替换：replace
>第一个参数：被替换的字符串，第二个参数：替换的字符串
```python
replace_tese = "hello this is a replace test"
replace_test.replace("this","kao")

hello kao is a replace test
```

### 查找索引：index
>获取字符第一次出现的索引，将希望搜索的字符作为参数
```python
try:
    print(“aninals”.index("i"))
except:
    print("not found.")
 
 2
```

### in关键字
>检查某个字符是否在另一个字符串中，boolean
```python
"hello" in "hello world"
"hello" not in "hello world"

true
false
```

### 字符串转义:反斜杠 \
>
```python
print("hello \"world\"")
```

### 换行： \n
```python
print("\nhello\nworld")

hello
world
```

### 切片：
>获取一个可迭代对象元素的子集,第一个参数：起始索引
```python
fict = ["Toast", "asian", "austin", "orwell"]
print(fict[0:2])
print(fict[:2])
print(fict[2:])

['Toast', 'asian']
['Toast', 'asian']
['austin', 'orwell']
```

