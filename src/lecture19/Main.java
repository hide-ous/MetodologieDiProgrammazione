package lecture19;

//Example usage of the Builder Pattern
public class Main {
public static void main(String[] args) {
   Computer gamingRig = new Computer.ComputerBuilder("Intel i9", 32, 1024)
           .setGPU("NVIDIA RTX 3080")
           .setOS("Windows 11")
           .setBluetooth("Bluetooth 5.0")
           .setWiFi("WiFi 6")
           .setStylus("Wacom Stylus")
           .setFingerprintReader("Fingerprint Reader V3")
           .build();

   Computer basicPC = new Computer.ComputerBuilder("Intel i5", 8, 256)
           .build();

   System.out.println(gamingRig);
   System.out.println(basicPC);
}
}