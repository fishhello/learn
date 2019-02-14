## 字典
>用来存储键值对两个对象的容器，将一个对象映射到另一个对象，结果产生一个键值对（key-vlaue）,字典是无序的

### 创建字典
```python
 my_dict = dict()
 my_dict = {}
```

### 字典初始化
```python
fruits = {"apple":"red","banana":"yellow"}
```

### 字典添加元素
```python
fruits["green"] = "green"
```

### 根据key获取值
```python
fruits["green"] :"green"
```

### 元素是否存在
```python
"green" in fruits :True
```

### 删除字典中键值对
```python
del fruits["green"]
```

```python
find_number = {"1":"yes","2":"onh","3":"five","4":"did","5":"ok"}


your_number = input("请输入你的幸运数字：")
if your_number in find_number:
    print(find_number[your_number])
else:
    print("木有")
```