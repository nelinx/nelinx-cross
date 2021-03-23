# Dockerfile for building a cross developing environment.
#
# (c) 2017-2018 by Kaspter Ju <camus@rtavs.com>
#
# To build the environment invoke
#
# $ docker build -t bionic:amd64 -f amd64/Dockerfile.bionic .
#
# This creates a docker image called "<distro>:<arch>". Note that it will
# take a while if you are building this image the first time.
#
# Note that Docker requires a relatively recent Linux kernel.
# 3.8 is the current minimum.
#

FROM ubuntu:groovy
MAINTAINER Kaspter Ju "camus@rtavs.com"

ENV DEBIAN_FRONTEND=noninteractive
ENV TZ=Asia/Shanghai

#RUN echo "deb http://mirrors.163.com/ubuntu/ groovy main restricted universe multiverse" > /etc/apt/sources.list
#RUN echo "deb http://mirrors.163.com/ubuntu/ groovy-security main restricted universe multiverse" >> /etc/apt/sources.list
#RUN echo "deb http://mirrors.163.com/ubuntu/ groovy-updates main restricted universe multiverse" >> /etc/apt/sources.list
#RUN echo "deb http://mirrors.163.com/ubuntu/ groovy-backports main restricted universe multiverse" >> /etc/apt/sources.list

RUN apt-get update && \
    apt-get install -y \
       autoconf \
       bash-completion \
       bc \
       bison \
       build-essential \
       ccache \
       cmake \
       curl \
       cpio \
       device-tree-compiler \
       dosfstools \
       flex \
       git \
       gperf \
       gnupg \
       libncurses5-dev \
       libgl1-mesa-dev \
       libxml2-utils \
       libssl-dev  \
       locales \
       lunzip \
       mtools \
       parted \
       pkg-config \
       rsync \
       sudo  \
       unzip \
       vim \
       wget \
       zip \
       zlib1g-dev && \
    apt-get autoclean

RUN locale-gen en_US.UTF-8

ENV LANG=en_US.UTF-8 \
    LANGUAGE=en_US:en \
    LC_ALL=en_US.UTF-8

# install cross build toolchain
#RUN apt-get install -y \
#    crossbuild-essential-armhf \
#    crossbuild-essential-arm64 \
#    gcc-arm-none-eabi

#RUN apt-get install -y \
#        debootstrap \
#        qemu-user-static \
#        live-build && \
#    apt-get autoclean

# build uboot.its
#RUN apt-get install -y \
#        python-pyelftools && \
#    apt-get autoclean


#RUN apt-get install -y \
#        python && \
#    apt-get autoclean



RUN apt-get install -y \
        gstreamer1.0-tools \
        gstreamer1.0-plugins-good \
        gstreamer1.0-plugins-base \
        gstreamer1.0-plugins-bad \
        gstreamer1.0-plugins-ugly \
        gstreamer1.0-libav \
        libgstreamer1.0-dev \
        libgstrtspserver-1.0-dev \
        libgstreamer-plugins-base1.0-dev \
        libgstreamer-plugins-good1.0-dev \
    && apt-get autoclean


RUN apt-get install -y \
        libavcodec-dev \
        libavdevice-dev \
        libavfilter-dev \
        libavformat-dev \
        libavresample-dev \
        libavutil-dev \
    && apt-get autoclean

RUN apt-get install -y \
        qt5-default \
        libsdl2-dev \
    && apt-get autoclean



########################################################################
## use no-root user amd64
########################################################################

# create cross-build user amd64
RUN useradd -c 'cross-build-user' -m -d /home/amd64 -s /bin/bash amd64
RUN usermod -a -G sudo amd64
RUN usermod -a -G dialout amd64
RUN usermod -a -G video amd64

# default username, can be override by docker run environment variables
ENV USER=amd64 \
    HOME=/home/amd64

# Enable passwordless sudo for users under the "sudo" group
RUN sed -i -e \
      's/%sudo\s\+ALL=(ALL\(:ALL\)\?)\s\+ALL/%sudo ALL=NOPASSWD:ALL/g' \
      /etc/sudoers

USER amd64

RUN git config --global user.email "camus@rtavs.com"
RUN git config --global user.name "Kaspter Ju"
