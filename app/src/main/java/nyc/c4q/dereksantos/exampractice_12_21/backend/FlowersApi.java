package nyc.c4q.dereksantos.exampractice_12_21.backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowersApi {

    @GET("feeds/flowers.json")
    Call<List<Flowers>> getFlowersList();
}
