package lecture19;

import java.util.Optional;

//The Product: Computer
public class Computer {
 private String CPU;
 private int RAM;
 private int storage;
 private Optional<String> GPU;
 private Optional<String> OS;
 private Optional<String> Bluetooth;
 private Optional<String> WiFi;
 private Optional<String> stylus;
 private Optional<String> fingerprintReader;

 private Computer(ComputerBuilder builder) {
     this.CPU = builder.CPU;
     this.RAM = builder.RAM;
     this.storage = builder.storage;
     this.GPU = builder.GPU;
     this.OS = builder.OS;
     this.Bluetooth = builder.Bluetooth;
     this.WiFi = builder.WiFi;
     this.stylus = builder.stylus;
     this.fingerprintReader = builder.fingerprintReader;
 }

 // Static nested Builder class
 public static class ComputerBuilder {
     private String CPU;
     private int RAM;
     private int storage;
     private Optional<String> GPU = Optional.empty();
     private Optional<String> OS = Optional.empty();
     private Optional<String> Bluetooth = Optional.empty();
     private Optional<String> WiFi = Optional.empty();
     private Optional<String> stylus = Optional.empty();
     private Optional<String> fingerprintReader = Optional.empty();

     public ComputerBuilder(String CPU, int RAM, int storage) {
         this.CPU = CPU;
         this.RAM = RAM;
         this.storage = storage;
     }

     public ComputerBuilder setGPU(String GPU) {
         this.GPU = Optional.ofNullable(GPU);
         return this;
     }

     public ComputerBuilder setOS(String OS) {
         this.OS = Optional.ofNullable(OS);
         return this;
     }

     public ComputerBuilder setBluetooth(String Bluetooth) {
         this.Bluetooth = Optional.ofNullable(Bluetooth);
         return this;
     }

     public ComputerBuilder setWiFi(String WiFi) {
         this.WiFi = Optional.ofNullable(WiFi);
         return this;
     }

     public ComputerBuilder setStylus(String stylus) {
         this.stylus = Optional.ofNullable(stylus);
         return this;
     }

     public ComputerBuilder setFingerprintReader(String fingerprintReader) {
         this.fingerprintReader = Optional.ofNullable(fingerprintReader);
         return this;
     }

     public Computer build() {
         return new Computer(this);
     }
 }

 @Override
 public String toString() {
     return "Computer{" +
             "CPU='" + CPU + '\'' +
             ", RAM=" + RAM +
             ", storage=" + storage +
             ", GPU=" + GPU.orElse("None") +
             ", OS=" + OS.orElse("None") +
             ", Bluetooth=" + Bluetooth.orElse("None") +
             ", WiFi=" + WiFi.orElse("None") +
             ", stylus=" + stylus.orElse("None") +
             ", fingerprintReader=" + fingerprintReader.orElse("None") +
             '}';
 }
}


