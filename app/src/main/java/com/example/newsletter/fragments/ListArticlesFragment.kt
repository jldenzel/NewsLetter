package com.example.newsletter.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.adapter.ArticleAdapter
import com.example.newsletter.adapter.ArticleDetailsAdapter
import com.example.newsletter.adapter.ListArticlesHandler
import com.example.newsletter.data.ArticleRepository
import com.example.newsletter.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListArticlesFragment : Fragment(), ListArticlesHandler {
    private lateinit var recyclerView: RecyclerView

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_articles_fragment, container, false)
        recyclerView = view.findViewById(R.id.articles_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            val articles = ArticleRepository.getInstance().getArticles()
            bindData(articles)
        }
    }
        /**
         * Récuperation  de la liste des articles dans un thread secondaire
         */

        private fun getArticles() {
            lifecycleScope.launch(Dispatchers.IO) {
                val articles = ArticleRepository.getInstance().getArticles()
            }
        }

        /**
         * Remplir le recyclerview avec les données récupérées dans le web service
         * Cette action doit s'effectuer sur le thread principale
         */
        private fun bindData (articles: List<Article>) {
            lifecycleScope.launch(Dispatchers.Main) {
                val adapter = ArticleAdapter(articles)
                recyclerView.adapter = adapter
            }

            override fun showArticle(article: Article) {

            }

            override fun back() {
            }

            override fun showPage(url: String) {
            }
        }

}