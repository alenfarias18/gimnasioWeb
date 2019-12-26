
package modelo;

import java.util.List;

public interface operaciones {
    public String insertar(Object obj);
    public List<?> listar();
    public String eliminar(Object obj);
    public String actualizar(Object obj);
}
