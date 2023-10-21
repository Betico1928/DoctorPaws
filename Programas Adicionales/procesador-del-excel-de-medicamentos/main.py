import pandas as pd


def procesar_datos_con_formato_espaciado(df):
    output_strings = []
    for i, row in df.iterrows():
        nombre = row['NOMBRE']
        precio_venta = f"{row['PRECIO VENTA']:,.0f}".replace(",", ".")
        precio_compra = f"{row['PRECIO COMPRA']:,.0f}".replace(",", ".")
        unidades_disponibles = row['UNIDADES DISPONIBLES']
        unidades_vendidas = row['UNIDADES VENDIDAS']

        output_str = f"// {nombre} - ({i + 1})\n"
        output_str += f"repoMedicamento.save(new Medicamento(\"{nombre}\", {precio_venta}F, {precio_compra}F, {unidades_disponibles}, {unidades_vendidas}));\n\n"
        output_strings.append(output_str)
    return output_strings


def guardar_y_mostrar_todos(df, output_filepath):
    output_strings = procesar_datos_con_formato_espaciado(df)

    try:
        with open(output_filepath, 'w', encoding='utf-8') as file:
            file.writelines(output_strings)
        message = f"Los datos han sido guardados en: {output_filepath}"
    except Exception as e:
        message = f"Error al guardar los datos en un archivo: {str(e)}"

    return message, "".join(output_strings)


# Ruta al archivo Excel
ruta_archivo = '/Users/case/Desktop/UNIVERSITY/6to Semestre/Desarrollo Web/DoctorPaws/Archivos Varios/MEDICAMENTOS_VETERINARIA.xlsx'

# Cargar el archivo Excel en un DataFrame
try:
    df = pd.read_excel(ruta_archivo)
except Exception as e:
    print(f"Error al leer el archivo Excel: {str(e)}")
    df = None

# Si el DataFrame se cargó exitosamente, procesar los datos
if df is not None:
    output_filepath_espaciado = '/Users/case/Desktop/UNIVERSITY/6to Semestre/Desarrollo Web/DoctorPaws/Programas Adicionales/procesador-del-excel-de-medicamentos/medicamentos_output.txt'
    save_message_espaciado, output_all_data_espaciado = guardar_y_mostrar_todos(df, output_filepath_espaciado)
    print(save_message_espaciado)
    print(output_all_data_espaciado[:500])  # Imprimir los primeros 500 caracteres de la salida como ejemplo
