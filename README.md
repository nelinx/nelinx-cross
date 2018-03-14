# nelinx-cross


## OS requirements

* xenial 16.04 (LTS)
* docker
* qemu-user-static
* binfmt-support

* Add support for binfmts to `/etc/rc.local` for xenial

```bash
echo -1 > /proc/sys/fs/binfmt_misc/qemu-aarch64 || true
echo -1 > /proc/sys/fs/binfmt_misc/qemu-arm || true
echo ':qemu-aarch64:M::\x7fELF\x02\x01\x01\x00\x00\x00\x00\x00\x00\x00\x00\x00\x02\x00\xb7\x00:\xff\xff\xff\xff\xff\xff\xff\x00\xff\xff\xff\xff\xff\xff\xff\xff\xfe\xff\xff\xff:/usr/bin/qemu-aarch64-static:OCF' > /proc/sys/fs/binfmt_misc/register
echo ':qemu-arm:M::\x7fELF\x01\x01\x01\x00\x00\x00\x00\x00\x00\x00\x00\x00\x02\x00\x28\x00:\xff\xff\xff\xff\xff\xff\xff\x00\xff\xff\xff\xff\xff\xff\xff\xff\xfe\xff\xff\xff:/usr/bin/qemu-arm-static:OCF' > /proc/sys/fs/binfmt_misc/register
```

Run `/etc/rc.local` or restart system.

## Build cross-build enviroment.

```bash
cd live-cross
make
```

## Build application and other

Enter arm64 shell and build application

```bash
make arm64
```


Enter amd64 shell and build u-boot/kernel/rootfs etc

```bash
make amd64
```

## Others

binfmt-support:
https://github.com/ayufan-rock64/linux-build/blob/master/recipes/binfmt-misc.md
