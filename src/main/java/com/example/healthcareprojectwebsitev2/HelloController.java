package com.example.healthcareprojectwebsitev2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HelloController {

    // ==========================================
    // FXML UI ELEMENTS: NEWS PAGINATION
    // ==========================================
    @FXML private HBox newsPage1;
    @FXML private HBox newsPage2;
    @FXML private HBox newsPage3;
    @FXML private HBox newsPage4;
    @FXML private HBox newsPage5;
    @FXML private HBox newsPage6;

    @FXML private Button backButton;
    @FXML private Button nextButton;
    @FXML private Label pageLabel;

    private int currentPage = 1;
    private final int TOTAL_PAGES = 6;
    private HBox[] pages;

    // ==========================================
    // FXML UI ELEMENTS: SYSTEM DIAGRAM TABS
    // ==========================================
    @FXML private Label lblPatients;
    @FXML private Label indPatients;
    @FXML private Label contentPatients;

    @FXML private Label lblHospitals;
    @FXML private Label indHospitals;
    @FXML private Label contentHospitals;

    @FXML private Label lblDoctors;
    @FXML private Label indDoctors;
    @FXML private Label contentDoctors;

    @FXML private Label lblPharmacies;
    @FXML private Label indPharmacies;
    @FXML private Label contentPharmacies;

    // ==========================================
    // INITIALIZATION
    // ==========================================
    @FXML
    public void initialize() {
        // Store pages in an array for easy index access
        pages = new HBox[]{newsPage1, newsPage2, newsPage3, newsPage4, newsPage5, newsPage6};

        // Setup initial view
        updatePaginationView();
    }

    // ==========================================
    // LOGIC: NEWS PAGINATION
    // ==========================================
    @FXML
    protected void onNextClick() {
        if (currentPage < TOTAL_PAGES) {
            currentPage++;
            updatePaginationView();
        }
    }

    @FXML
    protected void onBackClick() {
        if (currentPage > 1) {
            currentPage--;
            updatePaginationView();
        }
    }

    private void updatePaginationView() {
        // 1. Hide all pages and remove them from layout calculations
        for (HBox page : pages) {
            if (page != null) {
                page.setVisible(false);
                page.setManaged(false);
            }
        }

        // 2. Show the current page
        if (pages[currentPage - 1] != null) {
            pages[currentPage - 1].setVisible(true);
            pages[currentPage - 1].setManaged(true);
        }

        // 3. Update the page indicator label
        pageLabel.setText(currentPage + " / " + TOTAL_PAGES);

        // 4. Disable/Enable buttons based on the current page
        backButton.setDisable(currentPage == 1);
        nextButton.setDisable(currentPage == TOTAL_PAGES);

        // Update styles for disabled state to make it visually clear
        if (currentPage == 1) {
            backButton.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #aaaaaa; -fx-border-color: #cccccc; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 6 20 6 20;");
        } else {
            backButton.setStyle("-fx-background-color: white; -fx-text-fill: #4c3c72; -fx-border-color: #584a75; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 6 20 6 20; -fx-cursor: hand;");
        }

        if (currentPage == TOTAL_PAGES) {
            nextButton.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #aaaaaa; -fx-border-color: #cccccc; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 6 20 6 20;");
        } else {
            nextButton.setStyle("-fx-background-color: white; -fx-text-fill: #4c3c72; -fx-border-color: #584a75; -fx-border-radius: 20; -fx-background-radius: 20; -fx-padding: 6 20 6 20; -fx-cursor: hand;");
        }
    }

    // ==========================================
    // LOGIC: SYSTEM DIAGRAM TABS
    // ==========================================
    private void resetDiagramTabs() {
        // Hide all content paragraphs
        contentPatients.setVisible(false);
        contentPatients.setManaged(false);
        contentHospitals.setVisible(false);
        contentHospitals.setManaged(false);
        contentDoctors.setVisible(false);
        contentDoctors.setManaged(false);
        contentPharmacies.setVisible(false);
        contentPharmacies.setManaged(false);

        // Hide all little caret indicators (^)
        indPatients.setVisible(false);
        indHospitals.setVisible(false);
        indDoctors.setVisible(false);
        indPharmacies.setVisible(false);

        // Reset all label styles to gray and normal weight
        String inactiveStyle = "-fx-font-size: 16px; -fx-text-fill: #61537a; -fx-padding: 0 0 5 0;";
        lblPatients.setStyle(inactiveStyle);
        lblHospitals.setStyle(inactiveStyle);
        lblDoctors.setStyle(inactiveStyle);
        lblPharmacies.setStyle(inactiveStyle);
    }

    @FXML
    protected void onPatientsTabClick() {
        resetDiagramTabs();
        contentPatients.setVisible(true);
        contentPatients.setManaged(true);
        indPatients.setVisible(true);
        lblPatients.setStyle("-fx-font-size: 16px; -fx-text-fill: #8b3d79; -fx-font-weight: bold; -fx-padding: 0 0 5 0;");
    }

    @FXML
    protected void onHospitalsTabClick() {
        resetDiagramTabs();
        contentHospitals.setVisible(true);
        contentHospitals.setManaged(true);
        indHospitals.setVisible(true);
        lblHospitals.setStyle("-fx-font-size: 16px; -fx-text-fill: #8b3d79; -fx-font-weight: bold; -fx-padding: 0 0 5 0;");
    }

    @FXML
    protected void onDoctorsTabClick() {
        resetDiagramTabs();
        contentDoctors.setVisible(true);
        contentDoctors.setManaged(true);
        indDoctors.setVisible(true);
        lblDoctors.setStyle("-fx-font-size: 16px; -fx-text-fill: #8b3d79; -fx-font-weight: bold; -fx-padding: 0 0 5 0;");
    }

    @FXML
    protected void onPharmaciesTabClick() {
        resetDiagramTabs();
        contentPharmacies.setVisible(true);
        contentPharmacies.setManaged(true);
        indPharmacies.setVisible(true);
        lblPharmacies.setStyle("-fx-font-size: 16px; -fx-text-fill: #8b3d79; -fx-font-weight: bold; -fx-padding: 0 0 5 0;");
    }
}