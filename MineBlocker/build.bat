@ECHO OFF
SET BINDIR=%~dp0
CD /D "%BINDIR%"
gradlew build
pause