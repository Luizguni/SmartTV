import static spark.Spark.*;
import com.google.gson.Gson;
import TV.SmartTv;

public class SmartTvAPI {
    public static void main(String[] args) {
        SmartTv tv = new SmartTv(); // Instância da SmartTv
        Gson gson = new Gson();

        // Configura a porta e os arquivos estáticos
        port(4567);
        staticFiles.location("/public");

        // Ligar a TV
        post("/ligar", (req, res) -> {
            tv.ligar();
            res.type("application/json");
            return gson.toJson(tv);
        });

        // Desligar a TV
        post("/desligar", (req, res) -> {
            tv.desligar();
            res.type("application/json");
            return gson.toJson(tv);
        });

        // Mudar canal (1 para cima, 0 para baixo)
        post("/canal/:valor", (req, res) -> {
            int valor = Integer.parseInt(req.params("valor"));
            if (valor == 1) {
                tv.mudarCanal(tv.canal + 1);
            } else if (valor == 0) {
                tv.mudarCanal(tv.canal - 1);
            }
            res.type("application/json");
            return gson.toJson(tv);
        });

        // Ajustar volume (1 para cima, 0 para baixo)
        post("/volume/:valor", (req, res) -> {
            int valor = Integer.parseInt(req.params("valor"));
            if (valor == 1) {
                tv.aumentarVolume();
            } else if (valor == 0) {
                tv.diminuirVolume();
            }
            res.type("application/json");
            return gson.toJson(tv);
        });

        // Status da TV
        get("/status", (req, res) -> {
            res.type("application/json");
            return gson.toJson(tv);
        });
    }
}
