## 元组
> 存储有序对象的容器。元组不可变，无法修改元组值

### 创建元组
```python
my_tuple = tuple()
my_tuple = ()
```

### 元组初始化
>即使元组内只有一个元素，也需要在后面加上逗号，
```python
my_tuple = ("hello", 2019,True)
```
```python
my_tuple = ("hello",)
```

### 根据元组下标取值
```python
my_tuple[1]
```

### 判断某元素是否存在元组
```python
2019 in my_tuple :True
"apple" not in my_tuple :True
```