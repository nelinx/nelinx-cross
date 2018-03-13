

TARGETS := amd64 arm32 arm64

.PHONY: $(TARGETS)

all: $(TARGETS)


.PHONY: arm32
arm32:
	@echo Building arm32v7 environment...
	@docker build -q -t xenial:arm32 -f arm32/Dockerfile.xenial .
	@docker build -q -t bionic:arm32 -f arm32/Dockerfile.bionic .


.PHONY: arm64
arm64:
	@echo Building arm64v8 environment...
	@docker build -q -t xenial:arm64 -f arm64/Dockerfile.xenial .
	@docker build -q -t bionic:arm64 -f arm64/Dockerfile.bionic .


.PHONY: amd64
amd64:
	@echo Building amd64-cross build environment...
	@docker build -q -t xenial:amd64 -f amd64/Dockerfile.xenial .
	@docker build -q -t bionic:amd64 -f amd64/Dockerfile.bionic .
