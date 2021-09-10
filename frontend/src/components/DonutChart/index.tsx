import axios from 'axios';
import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

function DonutChart() {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`https://devsuperior-dsvendas.herokuapp.com/sales/amount-by-seller`) // usando axios com o endereço da api teste remoto
            // axios.get(`${BASE_URL}/sales/amount-by-seller`) // usando axios com o endereço da api
            .then(response => {
                const data = response.data as SaleSum[];
                const myLabels = data.map(x => x.sellerName); // adicionado do jeito certo
                const mySeries = data.map(x => x.sum); // adicionado do jeito certo

                setChartData({ labels: myLabels, series: mySeries });
                // console.log(chartData);
            });
    }, []);

    //    forma errada 
    // axios.get(`${BASE_URL}/sales/amount-by-seller`) // usando axios com o endereço da api
    //     .then(response => {
    //         const data = response.data as SaleSum[];
    //         const myLabels = data.map(x => x.sellerName); // adicionado do jeito certo
    //         const mySeries = data.map(x => x.sum); // adicionado do jeito certo

    //         setChartData({ labels:myLabels, series: mySeries });
    //         console.log(chartData);
    // });

    // const mockData = {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart
            // options={{ ...options, labels: mockData.labels}}
            options={{ ...options, labels: chartData.labels }}
            // series={mockData.series}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;