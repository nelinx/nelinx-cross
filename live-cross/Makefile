

TARGETS := amd64 arm32 arm64

.PHONY: $(TARGETS)

all: $(TARGETS)


.PHONY: arm32
arm32:
	@echo Building arm32v7 environment...
	@docker build -q -t xenial:arm32 -f arm32/rtavs.xenial .
	@docker build -q -t bionic:arm32 -f arm32/rtavs.bionic .


.PHONY: arm64
arm64:
	@echo Building arm64v8 environment...
	@docker build -q -t xenial:arm64 -f arm64/rtavs.xenial .
	@docker build -q -t bionic:arm64 -f arm64/rtavs.bionic .


.PHONY: amd64
amd64:
	@echo Building amd64-cross build environment...
	@docker build -q -t xenial:amd64 -f amd64/rtavs.xenial .
	@docker build -q -t bionic:amd64 -f amd64/rtavs.bionic .
	@docker build -q -t stretch:amd64 -f amd64/rtavs.stretch .
