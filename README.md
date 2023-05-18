# ScreenshotCropperGUI

Contains GUI classes for ScreenshotCropper

## Packaging

Note that maven requires access to ScreenshotCropper in its repository to compile and package this project. To add ScreenshotCropper to the local repository, navigate to the project and use

`mvn install:install-file -Dfile=target/ScreenshotCropper-0.0.1-SNAPSHOT.jar -DgroupId=ScreenshotCropper -DartifactId=ScreenshotCropper -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DgeneratePom=true`
