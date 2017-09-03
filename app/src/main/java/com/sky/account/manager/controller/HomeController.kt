package com.sky.account.manager.controller

import com.sky.account.manager.model.AccountModel
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import java.net.URL
import java.util.*

/**
 * Created by sky on 17-8-17.
 */
class HomeController : Initializable {

    @FXML lateinit var tvTable: TableView<AccountModel>
    @FXML lateinit var name: TableColumn<AccountModel, String>
    @FXML lateinit var password: TableColumn<AccountModel, String>
    @FXML lateinit var desc: TableColumn<AccountModel, String>
    @FXML lateinit var createTime: TableColumn<AccountModel, String>

    override fun initialize(location: URL?, resources: ResourceBundle?) {

        initTable()
    }

    private fun initTable() {

        name.cellValueFactory = PropertyValueFactory<AccountModel, String>("name")
        password.cellValueFactory = PropertyValueFactory<AccountModel, String>("password")
        desc.cellValueFactory = PropertyValueFactory<AccountModel, String>("desc")
        createTime.cellValueFactory = PropertyValueFactory<AccountModel, String>("createTime")

        tvTable.items = FXCollections.observableArrayList(newData())

        println(">>>>>>>>>>>>>>> ${tvTable.selectionModel}")
    }

    fun onTableMouseEvent(event: MouseEvent) {

        if (MouseButton.SECONDARY == event.button) {

            println(">>>>>>>>>>>>>>>>>>>>>> $event")
        }
    }

    private fun newData(): List<AccountModel> {

        var data = ArrayList<AccountModel>()

        for (i in 1..100) {
            data.add(AccountModel(i, "sky", "123456", "test", "2017.9.4"))
        }

        return data;
    }
}