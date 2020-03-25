package com.e.vknew.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.vknew.R;
import com.e.vknew.ui.adapter.FeedAdapter;
import com.e.vknew.ui.adapter.StoriesAdapter;
import com.e.vknew.ui.models.FeedModel;
import com.e.vknew.ui.models.StoriesModel;

import java.util.ArrayList;
import java.util.List;

public class FeedFragment extends Fragment {

    private FeedViewModel feedViewModel;
    FeedAdapter newsAdapter;
    StoriesAdapter storiesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        feedViewModel =
                ViewModelProviders.of(this).get(FeedViewModel.class);
        View view = inflater.inflate(R.layout.fragment_feed, container, false);



//        storiesGenerator();
        RecyclerView storiesRecyclerView = (RecyclerView) view.findViewById(R.id.stories_recycler_view);
        RecyclerView.LayoutManager storiesLayoutManager = new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) storiesLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        storiesRecyclerView.setLayoutManager(storiesLayoutManager);

        storiesAdapter = new StoriesAdapter(getContext(),storiesGenerator());
        storiesRecyclerView.setAdapter(storiesAdapter);


//        newsGenerator();
        RecyclerView newsRecyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);
        RecyclerView.LayoutManager newsLayoutManager = new LinearLayoutManager(getActivity());
        newsRecyclerView.setLayoutManager(newsLayoutManager);

        newsAdapter = new FeedAdapter(getContext(),newsGenerator());
        newsRecyclerView.setAdapter(newsAdapter);



        return view;
    }

    private List<FeedModel> newsGenerator(){
        List<FeedModel> news = new ArrayList<>();

        FeedModel fm1 = new FeedModel("Motivation Portal | Мотивация" , "два часа назад" , "" ,"16" , R.drawable.profile1 , R.drawable.post2 ,"3" , "14", "4");
        FeedModel fm2 = new FeedModel("Шерлок - Sherlock" ,"три часа назад", "Попробуем...","104",R.drawable.profile3,R.drawable.post_sherlock,"41","5","16");
        FeedModel fm3 = new FeedModel("Topsify","2 марта 15:31","#TopsifyXBTS","761",R.drawable.profile2,R.drawable.post_topsify,"58","45","48K");
        FeedModel fm4 = new FeedModel("dev/null","27 февраля 21:47","Программист:интерфейс интуитивно понятен,тут каждый разберется.","3K",R.drawable.profile4,R.drawable.post_dev,"48","77","180K");
        FeedModel fm5 = new FeedModel("ITProger", "26 фервраля 00:15",null,"763",R.drawable.profile5,R.drawable.post5,"160","35","14K");
        FeedModel fm6 = new FeedModel("Цени жизни","10 января 04:59","Узнали?","3K",R.drawable.profile6,R.drawable.post6,"73","253","412");
        FeedModel fm7 = new FeedModel("Designer / Photoshop / Illustrator","6 января 15:22","- Фоны\n" +
                "\n" +
                "#фоны@desiignertm","23",R.drawable.profile7,R.drawable.post7,"2",null,"4");
        FeedModel fm8 = new FeedModel("Цени жизни","3 января 12:41","Выбирай!","342",R.drawable.profile6,R.drawable.post8,"171","104","66");
        FeedModel fm9 = new FeedModel("Я тебя люблю","1 января 00:56",null,"3K",R.drawable.profile9,R.drawable.post9,"677","34","1K");
        FeedModel fm10 = new FeedModel("dev/null","1 января 12:01","Когда написал 10 строк кода и они работают","4K",R.drawable.profile4,R.drawable.post10,"433","72","18K");

        news.add(fm1);
        news.add(fm2);
        news.add(fm3);
        news.add(fm4);
        news.add(fm5);
        news.add(fm6);
        news.add(fm7);
        news.add(fm8);
        news.add(fm9);
        news.add(fm10);

        return news;
    }

    private List<StoriesModel> storiesGenerator(){
        List<StoriesModel> stories = new ArrayList<>();

        StoriesModel sm1 = new StoriesModel(R.drawable.stories2,"Zhasaral");
        StoriesModel sm2 = new StoriesModel(R.drawable.stories3,"Topsify");
        StoriesModel sm3 = new StoriesModel(R.drawable.stories4,"Bai-Lin");
        StoriesModel sm4 = new StoriesModel(R.drawable.stories5,"Aiteke bi Foundation");
        StoriesModel sm5 = new StoriesModel(R.drawable.stories2,"NomadKZ");
        StoriesModel sm6 = new StoriesModel(R.drawable.stories3,"Raiyan");
        StoriesModel sm7 = new StoriesModel(R.drawable.stories4,"Hungry Birds");
        StoriesModel sm8 = new StoriesModel(R.drawable.stories5,"Fluppy");
        StoriesModel sm9 = new StoriesModel(R.drawable.stories2,"Teams");
        StoriesModel sm10 = new StoriesModel(R.drawable.stories3,"Tasty Food");

        stories.add(sm1);
        stories.add(sm2);
        stories.add(sm3);
        stories.add(sm4);
        stories.add(sm5);
        stories.add(sm6);
        stories.add(sm7);
        stories.add(sm8);
        stories.add(sm9);
        stories.add(sm10);

        return stories;
    }
}
