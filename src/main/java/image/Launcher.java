package image;

import java.io.File;
import java.util.List;

import image.edit.ModifyImage;
import image.reader.ReadFiles;

public class Launcher {

  public static void main(String[] args) throws Exception {
    List<File> imageFiles = ReadFiles.getImageFilesFromCurrentDirectory();
    ModifyImage modifyImages = new ModifyImage(imageFiles);
    modifyImages.addBorderToImageFiles();
    modifyImages.saveImages();
  }
}
