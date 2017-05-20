package wh.lyw.mvp.ui.activity;
import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.Random;
import butterknife.BindView;
import wh.lyw.mvp.R;
import wh.lyw.mvp.base.BaseActivity;
import wh.lyw.mvp.model.bean.Person;
import wh.lyw.mvp.contract.MainContract;
import wh.lyw.mvp.presenter.MainPresenter;
public class MainActivity extends BaseActivity<MainPresenter>implements MainContract.View<Person> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int GINK_URL1 = 1;
    private ProgressDialog mDialog;
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;
    @BindView(R.id.fab)
    public FloatingActionButton mFab;
    @BindView(R.id.tv)
    public TextView mTextView;
    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }
    @Override
    protected void init() {
        setSupportActionBar(mToolbar);
        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在李玉文");
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getGank(GINK_URL1);
            }
        });
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showDialog() {
        mDialog.show();
    }

    @Override
    public void onSucceed(Person data, int i) {
        if (i==GINK_URL1){
            Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
            List<Person.Result> results = data.getResults();
            mTextView.setText(results.get(new Random().nextInt(10)).toString());
            for (Person.Result result : results) {
                Log.e(TAG, result.toString());
            }
        }

    }

    @Override
    public void onFail(String err) {
        Log.e(TAG, err);
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideDialog() {
        mDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
