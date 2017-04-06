package lap.practica1;

import java.io.ObjectInputStream.GetField;

import unidad1.supermercado.PreciosYPromociones;

public class Principal {
	
	
	
	public static void main(String[] args){


		//verifica que se hayan ingresado los tres primeros argumentos
		//(nombre del local, CUIT, domicilio de local)
		if(args.length==3){
			String [] productosConPromo= PreciosYPromociones.getProductosPromoSegundaUnidad50PorCiento();
			String [][] productos = PreciosYPromociones.getProductos();
			String [][] productoVenta= PreciosYPromociones.getVentaPrueba();
			
			double mod=0;
			double descuentoP=0;
			double precioU=0;
			double descuento=0;
			double unidad=0;
			double total_producto=0;
			double total=0;
			double monto_pagar=0;

			//imprimir nombre del local, CUIT, y direccion del local
			
			System.out.println("" + args[0]);
			System.out.println("CUIT: " + args[1]);
			System.out.println("Domicilio: " + args[2]);
			System.out.println("");

			//recorre la lista de todos los productos que hay en el catalogo.
			for( int i =0; i < productos.length; i++){
				
				//recorre la lista de productos de una venta.
				for(int k=0;k<productoVenta.length; k++){
						
					if(productoVenta[k][0]==productos[i][0]){
						
						//obtiene la cantidad de unidades que se vendieron del producto
						unidad=Double.parseDouble(productoVenta[k][1]);
						//obtiene el precio unitario del producto
						precioU=Double.parseDouble(productos[i][2]);
						//precio total venta por producto
						total_producto=unidad*precioU;
						
						//imprimir el producto vendido(nombre, la cantidad, el precio unitario
						//y el precio total por producto).
						System.out.print(productos[i][1]);
						System.out.printf("\t %.3f \t %.2f \t%.2f \n", unidad, precioU, total_producto);
						
						
						total=total+total_producto;

						//recorre la lista de los productos que tienen promocion. 
						for(int j=0;j<productosConPromo.length; j++){
							//se fija si el producto en promocion coincide con 
							//el producto de la venta				
							if(productosConPromo[j]==productoVenta[k][0]){
							
								//obtiene el resto/mod para saber a cuantas unidades
								//se les debe hacer el descuento
								mod=unidad%2;
								
								//obtiene el descuento por producto
								descuentoP=(((unidad-mod)/2)*precioU)*0.5;
								
								//descuento total de la venta
								descuento=descuento+descuentoP;
							}
						}
					}
				}
			}
	
			monto_pagar = total-descuento;
	
			System.out.printf("Importe Total......................... %.2f \n", total);
	
			System.out.printf("Descuentos............................ %.2f \n", descuento);
	
			System.out.printf("Monto a Pagar......................... %.2f \n", monto_pagar);
			
		//En caso de no haber ingresado los datos del local se le muestra un mensaje de “error”
		}else{
			System.out.println("Se debe ingresar nombre del local, CUIT, y domicilio del local");
		}
	}

}

