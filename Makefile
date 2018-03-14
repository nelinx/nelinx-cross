

.PHONY: all

all:
	@echo Please use make amd64/arm32/arm64 environment. for example:
	@echo make amd64: entering amd64 environment, default bionic
	@echo make arm32: entering arm32 environment, default xenial
	@echo make arm64: entering arm64 environment, default xenial

.PHONY: arm32
arm32:
	@echo Entering arm32v7 environment ...
	@./docker-shell arm32 xenial

.PHONY: arm64
arm64:
	@echo Entering arm64v8 environment...
	@./docker-shell arm64 xenial

.PHONY: amd64
amd64:
	@echo Entering amd64 environment...
	@./docker-shell amd64 bionic
