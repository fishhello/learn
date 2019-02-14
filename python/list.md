## 列表
>以固定顺序保存任意对象的容器,列表是可变的（mutable）

### 列表的创建
```python
fruit = list()
fruit = []
```


### 列表赋值
>列表中的三个元素是有序的
```python
fruit = ["apple","pear","orange"]
```

### 列表中添加元素
```python
fruit.append("banana")
fruit.append(true)
fruit.append(1.1)
fruit.append(100)
```

### 列表中修改元素
>列表序号从0开始
```python
fruit[0] = "red"
```

### 列表删除列表最后一个元素
>不能对空列表使用pop
```python
fruit.pop()
```

### 合并两个列表
```
fruit = ["apple", "pear", "orange"]
color = ["red", "green", "yellow"]
print(fruit + color)
```

### 检查某个元素是否在列表里
```python
"apple" in fruit :true
"apple" not in color :true
```

### 列表大小
```python
len(color) :3
```

```python
colors = ["red", "yellow", "green"]


guess = input("猜猜颜色：")


if(guess in colors):
    print("猜对了")
else:
    print("再猜猜吧")
```