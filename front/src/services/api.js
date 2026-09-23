const API_URL = "http://localhost:8080";

export async function getDemandes() {

    const response = await fetch(
        `${API_URL}/demandes`
    );

    console.log("Status:", response.status);

    const data = await response.json();

    console.log("Demandes:", data);

    return data;
}