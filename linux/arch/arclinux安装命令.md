&emsp;��װarchlinuc֮ǰ��׼��-����wifki������װ

### 1.U������

- ʹ��GPT������UEFI����ģʽд��U��

- ʹ�����rufu

> ʹ��ddģʽ��װ�������û�г���media test failure,check cable����

### 2.���̷���

&emsp;90G��̬
/swap 		8G
/      		15G
/boot/efi	8G
/home		ʣ��

- �鿴ѡ��Ӳ��--����Ӳ�̵�size����
 lsblk

&emsp;ʹ�÷������߽��з���
&emsp;����ָ��Ӳ�̽��з�������[parted/fdisk](https://www.cnblogs.com/onlybobby/p/7018788.html)


  - ����Ӳ��
 parted /dev/sdb

  - �ƶ�Ӳ�̸�ʽΪgpt   msdos
 (parted) mklabel gpt

  - �鿴Ӳ�̷�����Ϣ
 (parted) print

  - /swap����
 (parted) mkpart primary linuxswap 1M 8G   

  - /boot/efi����
 (parted) mkpart primary ext4 8G 16G

  - /������
  (parted) mkpart primary ext4 16G 36G

  - /home����
  (parted) mkpart primary ext4 36G 100%

  - �˳�
  q

### �����ļ�ϵͳ--��ʽ��Ӳ��

- �鿴�������
  fdisk -l

- ��ʽ��ext4 ��ͨ����
  mkfs.ext4 /dev/xxx

- ��ʽ��swap
  mkswap /dev/xxx
  swapon /dev/xxx   //����swap

### ���ط���
&emsp;swap�������ù���

- home����  ������/mnt/home��
  mkdir /mnt/home
  mount /dev/xxx /mnt/home

- ������������/mnt��
  mount /dev/xxx /mnt

- efi����
  mkdir -p /mnt/boot/efi
  mount /dev/xx /mnt/boot/efi

### �༭���ھ���nano
  /etc/pacman.d/mirrorlist
  Server = http://mirrors.aliyun.com/archlinux/$repo/os/$arch

### ��װ������ϵͳ
  pacstrap /mnt base base-devel

### ����ϵͳ����fstab�ļ�
  genfstab -U /mnt >> /mnt/etc/fstab
  ������ɼ���ļ��Ƿ���ȷ ʹ�� cat /mnt/etc/fastab

### �л���ǰ��Ŀ¼
  arch-chroot /mnt

### �趨ʱ��
  ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
  //����ʱ���׼ Ϊ UTC�������� ʱ��Ư��:
  hwclock --systohc --utc

### ���ñ��ػ�
  pacman -S vim  //��һ���ܲ��ܰ�װ
  nano /etc/locale.gen   //��ע�����en_US.UTF-8 UTF-8��zh_CN.UTF-8 UTF-8

  //ִ��locale-gen������localeѶϢ
  locale-gen
  //��ϵͳ locale ����Ϊen_US.UTF-8
  echo LANG=en_US.UTF-8 > /etc/locale.conf

### ����������
  echo myhostname > /etc/hostname
  //��ӵ�hosts�ļ�
  /etc/hosts
  127.0.1.1	myhostname.localdomain	myhostname

### ����һ����ʼ RAM disk
  mkinitcpio -p linux

### ����root����
  passwd

### ��������--����

- ��װ������Ҫ�İ�
  pacman -S dialog wpa_supplicant netctl wireless_tools

- �鿴��������
  ip link show

[������:](https://wiki.archlinux.org/index.php/Netctl#Job_for_netctl.40wlan.28....29.service_failed)
  &emsp;ip link set xxx down
  &emsp;netctl start xxx-ssid

### ��������

```
//��������ټ���
pacman -S grub
grub-install �Crecheck /dev/sda
```

- ��װuefi��
  pacman -S grub-efi-x86_64

- efi������
  pacman -S efibootmgr

- ��װ��efi����
  grub-install �Cefi-directory=/boot/efi �Cbootloader-id=grub

- ���������ļ�
  grub-mkconfig -o /boot/grub/grub.cfg

### �˳�chrootģʽ,��ж����
  umount ����
  shutdown now �ο�U���ٿ���
