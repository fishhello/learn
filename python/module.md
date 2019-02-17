## 模块
> 一个大型的程序可以分割成许多个包含Python代码的文件，称为模块

### 导入内置模块
> [官方内置模块](https://docs.python.org/3/py-modindex.html),导入模块后使用模块名.代码 调用

> 导入命令：import

```python
import math

#计算2的3次方
math.pow(2, 3)

8.0
```
```python
import random
#随机数
math.random(0, 100)

52
```
```python
import statistics
#均值
nums = [1, 5, 33, 21, 55]
statistics.mean(nums) :23

#中值
statistics.median(nums) :21

#众值
statistics.mode(nums) :无
```

### 导入外部模块
> 定义一个新的模块，在另一个模块中调用

> 导入模块时，其中的代码都会被执行

> 模块中的测试代码不希望输出时，可以用if__name__ = "__main__"语句

```python
def print_hello():
    print("Hello")

#命令为 hello.py
```
```python
import hello
hello.print_hello()

Hello
#同一个目录下新建另外一个py文件调用
```
```python
if__name__ == "__main__":
    print("hello")
```