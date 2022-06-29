package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        // TODO Remover Mock de Noticias
        news = new MutableLiveData<>();
        List<News> news = new ArrayList<>();
        news.add(new News("São Paulo Tem Desfalque Importante.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s."));
        news.add(new News("São Paulo Joga Sábado.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "));
        news.add(new News("Copa do Mundo Feminino Está Terminando", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}