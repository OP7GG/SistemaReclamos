package municipalidad.ui;

import municipalidad.servicios.SistemaReclamos;
import java.util.Scanner;

public class MenuPrincipal {
    
    private SistemaReclamos sistema;
    private Scanner scanner;
    
    public MenuPrincipal() {
        sistema = new SistemaReclamos();
        scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        System.out.println("   SISTEMA DE GESTION DE RECLAMOS CIUDADANOS ");
        System.out.println("        Municipalidad de San Rafael            ");
        
        cargarDatos();
        
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Selecciona una opcion: ");
            salir = procesarOpcion(opcion);
        }
        
        System.out.println("Gracias por usar el sistema.");
    }
    
    private void mostrarMenu() {
        System.out.println("1. Registrar reclamo");
        System.out.println("2. Eliminar reclamo");
        System.out.println("3. Buscar por codigo (BST)");
        System.out.println("4. Buscar por RUT");
        System.out.println("5. Cambiar estado de reclamo");
        System.out.println("6. Atender siguiente (Cola)");
        System.out.println("7. Ver todos los reclamos");
        System.out.println("8. Ver inorden (BST)");
        System.out.println("9. Ver preorden");
        System.out.println("10. Ver postorden");
        System.out.println("11. Ordenar con Bubble Sort");
        System.out.println("12. Ordenar con Merge Sort");
        System.out.println("13. Ver alertas de vencimiento");
        System.out.println("14. Ver historial de cambios");
        System.out.println("15. Ver estadisticas");
        System.out.println("0. Salir");
    }
    
    private boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarReclamo();
                break;
            case 2:
                eliminarReclamo();
                break;
            case 3:
                buscarPorCodigo();
                break;
            case 4:
                buscarPorRut();
                break;
            case 5:
                cambiarEstado();
                break;
            case 6:
                sistema.atenderSiguiente();
                break;
            case 7:
                sistema.mostrarTodos();
                break;
            case 8:
                sistema.mostrarInorden();
                break;
            case 9:
                sistema.mostrarPreorden();
                break;
            case 10:
                sistema.mostrarPostorden();
                break;
            case 11:
                sistema.ordenarPorPrioridad();
                break;
            case 12:
                sistema.ordenarConMergeSort();
                break;
            case 13:
                sistema.alertasVencimiento();
                break;
            case 14:
                sistema.mostrarHistorial();
                break;
            case 15:
                sistema.estadisticas();
                break;
            case 0:
                return true;
            default:
                System.out.println("Opcion invalida");
        }
        return false;
    }
    
    private void registrarReclamo() {
        System.out.println("\nRegistrar Reclamo");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("RUT: ");
        String rut = scanner.nextLine();
        
        System.out.println("Tipos: ALUMBRADO, RESIDUOS, SEGURIDAD, CALLES, OTRO");
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        
        int prioridad = leerEntero("Prioridad (1-4): ");
        int dias = leerEntero("Dias para vencimiento: ");
        
        sistema.registrarReclamo(nombre, rut, tipo, descripcion, prioridad, dias);
    }
    
    private void eliminarReclamo() {
        System.out.print("\nCodigo del reclamo a eliminar: ");
        String codigo = scanner.nextLine();
        sistema.eliminarReclamo(codigo);
    }
    
    private void buscarPorCodigo() {
        System.out.print("\nCodigo a buscar: ");
        String codigo = scanner.nextLine();
        sistema.buscarPorCodigo(codigo);
    }
    
    private void buscarPorRut() {
        System.out.print("\nRUT a buscar: ");
        String rut = scanner.nextLine();
        sistema.buscarPorRut(rut);
    }
    
    private void cambiarEstado() {
        System.out.print("\nCodigo del reclamo: ");
        String codigo = scanner.nextLine();
        
        System.out.println("Estados: PENDIENTE, EN_PROCESO, RESUELTO, CERRADO");
        System.out.print("Nuevo estado: ");
        String estado = scanner.nextLine();
        
        sistema.cambiarEstado(codigo, estado);
    }
    
    private void cargarDatos() {
        System.out.println("\nCargando datos de prueba...");
        
        sistema.registrarReclamo("Cristian Toro", "12345678-9", "ALUMBRADO", 
                                "Luminaria apagada en calle principal", 2, 5);
        
        sistema.registrarReclamo("Andres Venegas", "98765432-1", "RESIDUOS", 
                                "No pasan a recoger basura", 1, 2);
        
        sistema.registrarReclamo("Felipe gonzalez", "55555555-5", "CALLES", 
                                "Bache en la calle", 2, 7);
        
        sistema.registrarReclamo("Ignacio Gonzalez", "11111111-1", "SEGURIDAD", 
                                "Robo de cables", 1, 1);
        
        sistema.registrarReclamo("Bastian Lopez", "22222222-2", "OTRO", 
                                "Arboles sin poda", 3, 15);
        
        System.out.println("Datos cargados\n");
    }
    
    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Numero invalido");
            return 0;
        }
    }
    
    public static void main(String[] args) {
        new MenuPrincipal().iniciar();
    }
}