

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class Biblioteca {

    private ArrayList<Libro> almaLibros;

    public ArrayList<Libro> getAlmaLibros() {
        return almaLibros;
    }

//    @XmlElement(name = "Libro")
    public void setAlmaLibros(ArrayList<Libro> almaLibros) {
        this.almaLibros = almaLibros;
    }

    public Biblioteca() {
    }
    
public static void actualizarfichero(ArrayList<Libro> alma){
    
    try {
            //llistaLlibres.add(llibre);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            DOMImplementation imp = dBuilder.getDOMImplementation();

            Document documento = imp.createDocument(null, "libros", null);
            documento.setXmlVersion("1.0");

            //crea llibre
            for (Libro l : alma) {
                Element libro = documento.createElement("libro");
                libro.setAttribute("id", String.valueOf(l.getId()));

                //crea titul
                Element titulo = documento.createElement("titulo");
                Text tituloTXT = documento.createTextNode(l.getTitulo());
                titulo.appendChild(tituloTXT);
                libro.appendChild(titulo);

                //crea autor
                Element autor = documento.createElement("autor");
                Text autorTXT = documento.createTextNode(l.getAutor());
                autor.appendChild(autorTXT);
                libro.appendChild(autor);

                //crea any
                Element año = documento.createElement("anyo");
                Text añoTXT = documento.createTextNode(String.valueOf(l.getAnyo()));
                año.appendChild(añoTXT);
                libro.appendChild(año);

                //crea editorial
                Element editorial = documento.createElement("editorial");
                Text editorialTXT = documento.createTextNode(l.getEditorial());
                editorial.appendChild(editorialTXT);
                libro.appendChild(editorial);

                //crea pagines
                Element paginas = documento.createElement("numeroPaginas");
                Text paginasTXT = documento.createTextNode(String.valueOf(l.getCantPaginas()));
                paginas.appendChild(paginasTXT);
                libro.appendChild(paginas);

                documento.getDocumentElement().appendChild(libro);
            }

            Source src = new DOMSource(documento);
            Result res = new StreamResult(new File("Libros2.xml"));

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(src, res);

        } catch (Exception e) {
            System.out.println(e);
        }
    
    
    
    
    
}

public static ArrayList<Libro> leerFichero(){
    ArrayList<Libro> almaLibros = new ArrayList<>();
    NodeList nodeList;
try {
     
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(new File("Libros2.xml"));

            nodeList = document.getElementsByTagName("libro");
            document.getDocumentElement().normalize();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Libro lib = new Libro();
                Node node = nodeList.item(i);
              
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;
                    lib.setId(Integer.parseInt(elemento.getAttribute("id")));
                    lib.setTitulo(elemento.getElementsByTagName("titulo").item(0).getTextContent());
                    lib.setAutor(elemento.getElementsByTagName("autor").item(0).getTextContent());
                    lib.setAnyo(Integer.parseInt(elemento.getElementsByTagName("anyo").item(0).getTextContent()));
                    lib.setEditorial(elemento.getElementsByTagName("editorial").item(0).getTextContent());
                    lib.setCantPaginas(Integer.parseInt(elemento.getElementsByTagName("numeroPaginas").item(0).getTextContent()));

                    almaLibros.add(lib);

                }

            }

        } catch (Exception e) {

        }
        return almaLibros;

}

}
