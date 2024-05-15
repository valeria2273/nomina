
class nomina {
    String nombres;
    String apellidos;
    String documento;
    int diasTrabajados;
    double salarioBase;
    double subsidioTransporte;

    public Empleado(String nombres, String apellidos, String documento, int diasTrabajados, double salarioBase, double subsidioTransporte) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.diasTrabajados = diasTrabajados;
        this.salarioBase = salarioBase;
        this.subsidioTransporte = subsidioTransporte;
    }

    public double calcularDevengos() {
        double devengos = (salarioBase / 30) * diasTrabajados;
        if (salarioBase <= 2 * 1160000) {
            devengos += (subsidioTransporte / 30) * diasTrabajados;
        }
        return devengos;
    }

    public double calcularDescuentos() {
        double devengos = calcularDevengos();
        double salud = devengos * 0.04;
        double pension = devengos * 0.04;
        return salud + pension;
    }

    public double calcularNetoPagar() {
        return calcularDevengos() - calcularDescuentos();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento='" + documento + '\'' +
                ", diasTrabajados=" + diasTrabajados +
                ", salarioBase=" + salarioBase +
                ", subsidioTransporte=" + subsidioTransporte +
                ", devengos=" + calcularDevengos() +
                ", descuentos=" + calcularDescuentos() +
                ", netoPagar=" + calcularNetoPagar() +
                '}';
    }
}

public class LiquidacionNomina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        String respuesta;
        do {
            System.out.print("Nombres: ");
            String nombres = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Documento: ");
            String documento = scanner.nextLine();
            System.out.print("Días trabajados: ");
            int diasTrabajados = Integer.parseInt(scanner.nextLine());
            System.out.print("Salario base mensual: ");
            double salarioBase = Double.parseDouble(scanner.nextLine());
            double subsidioTransporte = 140606; // Valor del subsidio de transporte para el año 2024
            if (salarioBase > 2 * 1160000) {
                subsidioTransporte = 0;
            }

            Empleado empleado = new Empleado(nombres, apellidos, documento, diasTrabajados, salarioBase, subsidioTransporte);
            empleados.add(empleado);

            System.out.print("¿Desea agregar otro empleado? (si/no): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        scanner.close();
    }
}



