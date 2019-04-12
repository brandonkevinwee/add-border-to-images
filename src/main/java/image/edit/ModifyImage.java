package image.edit;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class ModifyImage {
  Map<File, BufferedImage> images = new HashMap<File, BufferedImage>();

  public ModifyImage(List<File> files) throws Exception {
    for (File file : files) {
      images.put(file, ImageIO.read(file));
    }
  }

  public void addBorderToImageFiles() {
    for (BufferedImage bufferedImage : images.values()) {
      Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
      graphics.setStroke(new BasicStroke(2));
      graphics.setColor(Color.BLACK);
      graphics.drawRect(1, 1, bufferedImage.getWidth() - 2, bufferedImage.getHeight() - 2);
    }
  }

  public void saveImages() throws Exception {
    for (Map.Entry<File, BufferedImage> image : images.entrySet()) {
      String fileName = image.getKey().getName();
      String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
      ImageIO.write(image.getValue(), fileExtension, image.getKey());
    }
  }
}
