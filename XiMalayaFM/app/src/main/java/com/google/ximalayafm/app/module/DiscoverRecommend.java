package com.google.ximalayafm.app.module;




import com.google.ximalayafm.app.module.json11.DiscoverColumns;
import com.google.ximalayafm.app.module.json11.EditorRecommendAlbums;
import com.google.ximalayafm.app.module.json11.HotRecommends;
import com.google.ximalayafm.app.module.json11.SpecialColumn;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class DiscoverRecommend {

    private EditorRecommendAlbums editorRecommendAlbums;

    private SpecialColumn specialColumn;

    private DiscoverColumns discoverColumns;

    private HotRecommends hotRecommends;

    public DiscoverColumns getDiscoverColumns() {
        return discoverColumns;
    }

    public EditorRecommendAlbums getEditorRecommendAlbums() {
        return editorRecommendAlbums;
    }

    public HotRecommends getHotRecommends() {
        return hotRecommends;
    }

    public SpecialColumn getSpecialColumn() {
        return specialColumn;
    }

    public void parseJSON(JSONObject json) throws JSONException {

        if (json != null) {

            JSONObject object =
                    json.getJSONObject("discoveryColumns");

            discoverColumns = new DiscoverColumns();
            discoverColumns.parseJSON(object);

            object = json.getJSONObject("editorRecommendAlbums");
            editorRecommendAlbums = new EditorRecommendAlbums();
            editorRecommendAlbums.parseJSON(object);

            object = json.getJSONObject("hotRecommends");
            hotRecommends = new HotRecommends();
            hotRecommends.parseJSON(object);

            object = json.getJSONObject("specialColumn");
            specialColumn = new SpecialColumn();
            specialColumn.parseJSON(object);


        }

    }


    @Override
    public String toString() {
        return "DiscoverRecommend{" +
                "discoverColumns=" + discoverColumns +
                ", editorRecommendAlbums=" + editorRecommendAlbums +
                ", specialColumn=" + specialColumn +
                ", hotRecommends=" + hotRecommends +
                '}';
    }
}
