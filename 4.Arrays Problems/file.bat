@echo off
for /l %%i in (1,1,100) do (
    echo public class File%%i { } > File%%i.java
)